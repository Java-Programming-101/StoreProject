import React, { Component } from 'react';
import 'whatwg-fetch';

class SubMenu extends Component {

    render() {
        let itemsPerPage = 5;
        let numberOfPages = this.props.categories.length / itemsPerPage;
        let pages = [];
        let page = [];
        let c = 0;

        numberOfPages = ( this.props.categories.length % itemsPerPage > 0 ? numberOfPages++ : numberOfPages );

        while(numberOfPages > 0) {
            for(let i = 0; i < itemsPerPage && c < this.props.categories.length; i++ ) {
                page.push(this.props.categories[c]);
                c++;
            }
            pages.push(page);
            numberOfPages--;
            page = [];
        }

        let cols = pages.map( (page) => {
            return <div className="col1">
                        <div className="h_nav">
                            <ul>
                                {
                                    page.map((category) => {
                                        return (<li><a href="women.html">{category.name}</a></li>)
                                    })
                                }
                            </ul>
                        </div>
                   </div>

        });

        return (
            <div className="megapanel">
                <div className="row">
                    {cols}
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