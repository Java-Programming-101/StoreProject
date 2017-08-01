import React, { Component } from 'react';
import SubMenu from './SubMenu';
import 'whatwg-fetch';

const API_URL = 'http://localhost:8088';
const API_HEADERS = {
    'Content-Type':'application/json',
    'Authorization':'any-string-you-like' // The authorization is not needed for local server
};

class MenuItem extends Component {
    constructor(props) {
        super(props);
        this.state = { categories: [] };
    }

    componentDidMount() {
        fetch(API_URL+'/category/findSubCategories/'+this.props.categoryId,{headers:API_HEADERS})
        .then((response) => response.json())
        .then((json) => {
            this.setState({categories:json});
        })
        .catch((error) => {
            console.log('Error fetching and parsing data',error);
        });
    }

    render() {
        return (
          console.log("MenuItem category props ===", this.props.categories),
          console.log("MenuItem category state ===", this.state.categories),
            <li className="grid"><a className={this.props.class} href={this.props.href}>{this.props.caption}</a>
                <SubMenu categories={this.state.categories} />
            </li>
        );
    }
}
export default MenuItem;
