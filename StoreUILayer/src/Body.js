import React, { Component } from 'react';
import Navigator from './Navigator';
import Header from './Header';
import Arrivals from './Arrivals';

class Body extends Component{
    render(){
      return(
      <div className="header_bg">
        <div className="container">
          <Header />
          <div className="row">
            <div className="col">
              <Navigator/>
            </div>
          </div>
        </div>
        <Arrivals />
      </div>

      )
    }
}

export default Body;
