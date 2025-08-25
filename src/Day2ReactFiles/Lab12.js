import React, { Component } from 'react';

/**
 * Functional Component to display a list of television models.
 * It receives the list of models as a prop.
 */
// The TelevisionList component is a functional component that displays the television models.
function TelevisionList(props) {
  // Checks if the models prop exists and has items to display.
  const hasModels = props.models && props.models.length > 0;

  return (
    <div className="mt-3">
      <h2 className="mb-3 fw-bold">Available Television Models</h2>
      {hasModels ? (
        // If there are models, it maps through the array and creates a list item for each one.
        <ul className="ps-3 text-start">
          {props.models.map((model, index) => (
            <li key={index}>{model}</li>
          ))}
        </ul>
      ) : (
        // If there are no models, it displays a message.
        <p className="text-muted fst-italic">No television models added yet.</p>
      )}
    </div>
  );
}

/**
 * Class Component to manage the state of the television models.
 * This component handles user input and updates the state.
 */
// The TelevisionManager is a class component that manages the state.
class TelevisionManager extends Component {
  // The constructor initializes the state with a default list of models and an empty string for the new model.
  constructor(props) {
    super(props);
    this.state = {
      televisionModels: ['LG', 'Samsung', 'Bravia'],
      newModel: ''
    };
  }

  // handleInputChange updates the newModel state as the user types in the input field.
  handleInputChange = (event) => {
    this.setState({ newModel: event.target.value });
  };

  // handleAddModel adds the new model from the input to the list of televisionModels in the state.
  handleAddModel = () => {
    const { newModel, televisionModels } = this.state;
    
    // It prevents adding empty or whitespace-only strings.
    if (newModel.trim() !== '') {
      this.setState({
        // A new array is created with all the previous models plus the new one.
        televisionModels: [...televisionModels, newModel.trim()],
        // The input field is cleared by resetting newModel to an empty string.
        newModel: ''
      });
    }
  };

  // The render method defines the component's UI.
  render() {
    return (
      <div className="container d-flex justify-content-center mt-5">
        <div className="col-12 col-md-6 col-lg-5 d-flex flex-column align-items-start">
          <h1 className="mb-4 fw-bold text-center">Television Manager</h1>
          
          <div className="input-group mb-4">
            <input
              type="text"
              // The input's value is controlled by the component's state.
              value={this.state.newModel}
              // The onChange event calls the handleInputChange method.
              onChange={this.handleInputChange}
              className="form-control"
              placeholder="Enter television model"
            />
            <button
              className="btn btn-outline-dark"
              // The onClick event calls the handleAddModel method.
              onClick={this.handleAddModel}
            >
              Add
            </button>
          </div>
          
          {/* Models displayed exactly below heading */}
          {/* The TelevisionList component is rendered, passing the televisionModels from the state as a prop. */}
          <TelevisionList models={this.state.televisionModels} />
        </div>
      </div>
    );
  }
}

export default TelevisionManager;