import React, { Component } from 'react';

class ImageItem extends Component {
    render() {
        return (
          <div className="col-md-6 arriv-left">
              <img src={"images/"+this.props.category.image} className="img-responsive img-thumbnail" alt="" height="390" width="560"/>
              <div className="arriv-info">
                  <h3>{this.props.category.caption}</h3>
                  <p>{this.props.category.description}</p>
                  <div className="crt-btn">
                      <a href="details.html">TAKE A LOOK</a>
                  </div>
              </div>
          </div>
        );
    }
}
export default ImageItem;
