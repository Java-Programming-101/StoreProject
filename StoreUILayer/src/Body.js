import React, { Component } from 'react';
import Navigator from './Navigator';
import Header from './Header';

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
      </div>

      )
    }
}

export default Body;
