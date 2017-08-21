import React, { Component } from 'react';
import MenuItem from './MenuItem';
import 'whatwg-fetch';

class Navigator extends Component {
    render() {
        var categoriesElements = this.props.categories.map((category,index) => {
                                    var c = 'color'+(index+2);
                                    return <MenuItem category={category} categoryId={category.id} class={c} caption={category.name} href="#" />
        });
        return (
            <ul className="megamenu skyblue">
                <li className="active grid">
                    <a className="color1" href="index.html">Home</a>
                </li>
                {categoriesElements}
            </ul>
        );
    }

    componentDidUpdate() {
        window.refresh();
    }
}
export default Navigator;
