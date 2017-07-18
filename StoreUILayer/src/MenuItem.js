import React, { Component } from 'react';

class MenuItem extends Component {
    render() {
        return (
            <li>
                <a className={this.props.class} href={this.props.href}>{this.props.caption}</a>
            </li>
        );
    }
}
export default MenuItem;