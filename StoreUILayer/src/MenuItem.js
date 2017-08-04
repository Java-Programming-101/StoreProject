import React, { Component } from 'react';
import SubMenu from './SubMenu';
import 'whatwg-fetch';

class MenuItem extends Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
        this.state = {};
    }

    handleChange(e) {
        this.props.categories = e.props.value;
    }

    render() {
        return (
          console.log("MenuItem category props ===", this.props.categories),
          console.log("MenuItem category state ===", this.state.categories),
            <li className="grid"><a className={this.props.class} href={this.props.href}>{this.props.caption}</a>
                <SubMenu categories={this.props.category.children} />
            </li>
        );
    }
}
export default MenuItem;
