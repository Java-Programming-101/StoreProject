import React, { Component } from 'react';

class MenuItem extends Component {
    constructor(props) {
        super(props);
        this.state = { categories: [] };
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/categories'}).done(response => {
        			this.setState({categories: response.entity._embedded.categories});
        		});
    }

    render() {
        return (
            <li>
                <a className={this.props.class} href={this.props.href}>{this.props.caption}</a>
            </li>
        );
    }
}
export default MenuItem;