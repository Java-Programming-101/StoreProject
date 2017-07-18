import React, { Component } from 'react';
import MenuItem from './MenuItem';

class Navigator extends Component {
    render() {
        return (
            <ul className="megamenu skyblue">
                <li className="active grid">
                    <a className="color1" href="index.html">Home</a>
                </li>
                <li className="grid">
                    <a className="color2" href="#">new arrivals</a>
                </li>
                <MenuItem class="color3" caption="TUXEDO" href="#"/>
                <MenuItem class="color4" caption="SWEATER" href="#"/>
            </ul>
        );
    }
}
export default Navigator;