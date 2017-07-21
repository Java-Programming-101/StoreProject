import React, { Component } from 'react';
import SubMenu from './SubMenu';

class MenuItem extends Component {
    render() {
        return (
            <li className="grid"><a className={this.props.class} href={this.props.href}>{this.props.caption}</a>
                <SubMenu id={this.props.categoryId} />
            </li>
        );
    }
}
export default MenuItem;