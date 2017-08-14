import React, {Component} from 'react';
import ImageItem from './ImageItem';


class ImagePanel extends Component{
  render(){
    var imageElements = this.props.categories.map((category) => {
                                return <ImageItem category={category} />
    });
    return (
        <div className="arriv">
            <div className="container">
                <div className="arriv-top">
                  {imageElements}
                </div>
            </div>
        </div>
      );
  }
}

export default ImagePanel;
