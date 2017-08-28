import React, { Component } from 'react';
import Navigator from './Navigator';
import Header from './Header';
import ImagePanel from './ImagePanel'
import {getEnvironment} from './Config';

const API_HEADERS = {
    'Content-Type':'application/json',
    'Authorization':'any-string-you-like' // The authorization is not needed for local server
};

class Body extends Component{
    constructor(props) {
        super(props);
        this.state = { categories: [] };
    }

    componentDidMount() {
        fetch(getEnvironment().apiURL+'/category/findFirstLevel',{headers:API_HEADERS})
        .then((response) => response.json())
        .then((responseData) => {
          console.log(responseData);
            this.setState({categories:responseData});
        })
        .catch((error) => {
            console.log('Error fetching and parsing data',error);
        });
    }

    render(){
      return(
      <div className="header_bg">
        <div className="container">
          <Header />
          <div className="row">
            <div className="col">
              <Navigator categories={this.state.categories}/>
            </div>
          </div>
        </div>
        <ImagePanel categories={this.state.categories}/>
      </div>
      )
    }
}

export default Body;
