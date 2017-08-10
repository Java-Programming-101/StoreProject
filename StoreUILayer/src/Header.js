import React, { Component } from 'react';


class Header extends Component{
  render(){
    return(

              <div className="header">
                  <div className="head-t">
                      <div className="logo">
                          <a href="index.html"><img src="images/logo.png" className="img-responsive" alt=""/> </a>
                      </div>

                      <div className="header_right">
                          <div className="rgt-bottom">
                              <div className="log">
                                  <div className="login">
                                      <div id="loginContainer"><a href="#" id="loginButton"><span>Login</span></a>
                                          <div id="loginBox">
                                              <form id="loginForm">
                                                  <fieldset id="body">
                                                      <fieldset>
                                                          <label htmlFor="email">Email Address</label>
                                                          <input type="text" name="email" id="email"/>
                                                      </fieldset>
                                                      <fieldset>
                                                          <label htmlFor="password">Password</label>
                                                          <input type="password" name="password" id="password"/>
                                                      </fieldset>
                                                      <input type="submit" id="login" value="Sign in"/>
                                                      <label htmlFor="checkbox"><input type="checkbox" id="checkbox"/> <i>Remember
                                                          me</i></label>
                                                  </fieldset>
                                                  <span><a href="#">Forgot your password?</a></span>
                                              </form>
                                          </div>
                                      </div>
                                  </div>
                              </div>
                              <div className="reg">
                                  <a href="register.html">REGISTER</a>
                              </div>
                              <div className="cart box_1">
                                  <a href="checkout.html">
                                      <h3><span className="simpleCart_total">$0.00</span> (<span id="simpleCart_quantity"
                                                                                             className="simpleCart_quantity">0</span>
                                          items)<img src="images/bag.png" alt=""/></h3>
                                  </a>
                                  <p><a href="javascript:;" className="simpleCart_empty">(empty card)</a></p>
                                  <div className="clearfix"></div>
                              </div>
                              <div className="create_btn">
                                  <a href="checkout.html">CHECKOUT</a>
                              </div>
                              <div className="clearfix"></div>
                          </div>
                          <div className="search">
                              <form>
                                  <input type="text" value="" placeholder="search..."/>
                                  <input type="submit" value=""/>
                              </form>
                          </div>
                          <div className="clearfix"></div>
                      </div>
                      <div className="clearfix"></div>
                  </div>
              </div>
      )

  }
}

export default Header
