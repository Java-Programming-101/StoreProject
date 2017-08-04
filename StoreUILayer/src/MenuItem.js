import React, { Component } from 'react';
import SubMenu from './SubMenu';
import 'whatwg-fetch';

class MenuItem extends Component {
    render() {
        return (
            <li className="grid"><a className={this.props.class} href={this.props.href}>{this.props.caption}</a>
                <SubMenu categories={this.props.category.children} />
            </li>
        );
    }
}
export default MenuItem;