import React, { Component } from 'react';
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


    render() {
        var childElements = this.state.categories.map((category) => {
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