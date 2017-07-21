import React, { Component } from 'react';
import MenuItem from './MenuItem';
import 'whatwg-fetch';

const API_URL = 'http://localhost:8088';
const API_HEADERS = {
    'Content-Type':'application/json',
    'Authorization':'any-string-you-like' // The authorization is not needed for local server
};

class SubMenu extends Component {
    constructor(props) {
        super(props);
        this.state = { categories: [] };
    }

    componentDidMount() {
        console.log('componentDidMount()');
        fetch(API_URL+'/category/findSecondLevel/'+this.props.id,{headers:API_HEADERS})
        .then((response) => response.json())
        .then((responseData) => {
            this.setState({categories:responseData});
        })
        .catch((error) => {
            console.log('Error fetching and parsing data',error);
        });
    }

    render() {
        var childElements = this.state.categories.map((category,index) => {
                                    return <div className="col1">
                                                <div className="h_nav">
                                                    <h4>{category.name}</h4>
                                                    <ul>
                                                        <li><a href="women.html">new arrivals</a></li>
                                                        <li><a href="women.html">men</a></li>
                                                        <li><a href="women.html">women</a></li>
                                                        <li><a href="women.html">accessories</a></li>
                                                        <li><a href="women.html">kids</a></li>
                                                        <li><a href="women.html">brands</a></li>
                                                    </ul>
                                                </div>
                                            </div>
        });

        return (
            <div className="megapanel">
                <div className="row">
                    {childElements}
                </div>
                <div className="row">
                    <div className="col2"></div>
                    <div className="col1"></div>
                    <div className="col1"></div>
                    <div className="col1"></div>
                    <div className="col1"></div>
                </div>
            </div>
        );
    }
}
export default SubMenu;