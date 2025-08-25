import React from "react";

// Functional Component: shows the list
// FruitList receives an array of fruits as a prop and renders them in an unordered list.
const FruitList = ({ fruits }) => {
  return (
    <div className="mt-0">
      <h3 className="mt-2 mb-2">FruitList</h3>
      <ul className="d-inline-block text-start">
        {fruits.map((fruit, index) => (
          // The key prop is important for React to efficiently update the list.
          <li key={index}>{fruit}</li>
        ))}
      </ul>
    </div>
  );
};

// Class Component: manages state + input
// FruitManager is a class component that handles the state of the fruits and the input field.
class FruitManager extends React.Component {
  // The constructor initializes the state with a default list of fruits and an empty string for the new fruit.
  constructor(props) {
    super(props);
    this.state = {
      fruits: ["Apple", "Banana", "orange"],
      newFruit: ""
    };
  }

  // handleInputChange updates the state of newFruit as the user types in the input field.
  handleInputChange = (e) => {
    this.setState({ newFruit: e.target.value });
  };

  // handleAddFruit adds the new fruit to the fruits array in the state.
  handleAddFruit = () => {
    const { newFruit } = this.state;
    // It checks if the input is not empty before adding.
    if (newFruit.trim() !== "") {
      this.setState((prev) => ({
        // It creates a new array by spreading the previous fruits and adding the new one.
        fruits: [...prev.fruits, newFruit.trim()],
        // The input field is then cleared by setting newFruit back to an empty string.
        newFruit: ""
      }));
    }
  };

  // The render method defines the component's UI.
  render() {
    return (
      <div className="container d-flex justify-content-center mt-5">
        <div className="col-12 col-md-6 col-lg-5 d-flex flex-column align-items-start">
          {/* Heading above input */}
          <h2 className="mb-2">Fruits</h2>

          {/* Input + button */}
          <div className="input-group mb-2">
            <input
              type="text"
              // The input's value is controlled by the component's state.
              value={this.state.newFruit}
              // The onChange event is tied to the handleInputChange method.
              onChange={this.handleInputChange}
              className="form-control"
            />
            <button
              className="btn btn-outline-dark"
              // The onClick event is tied to the handleAddFruit method.
              onClick={this.handleAddFruit}
            >
              Add
            </button>
          </div>

          {/* FruitList below input */}
          {/* FruitList is rendered, and the fruits from the state are passed as a prop. */}
          <FruitList fruits={this.state.fruits} />
        </div>
      </div>
    );
  }
}

export default FruitManager;