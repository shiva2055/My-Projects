import React, { Component } from "react";

class Counter extends React.Component {
  state = {
    count: 0,
  };
  styles = {
    fontSize: 50,
    fontWeight: "bold",
  };
  render() {
    return (
      <React.Fragment>
        <span style={this.styles} class="badge badge-danger m-2">
          {" "}
          {this.formatCount()}
        </span>
        <button class="btn btn-success btn -sm">Home</button>
      </React.Fragment>
    );
  }
  formatCount() {
    const { count } = this.state; // object destructering
    return count === 0 ? "Zero" : count;
  }
}

export default Counter;
