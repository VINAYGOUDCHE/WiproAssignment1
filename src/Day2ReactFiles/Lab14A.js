import React, { Component } from "react";

// This is a React class component for an accessories form.
class AccessoriesForm extends Component {
  // The constructor initializes the component's state.
  constructor(props) {
    super(props);
    this.state = {
      accessoryName: "",
      description: "",
      category: "",
      brand: "",
      available: false,
      warranty: "",
      // submittedData will store an array of all form submissions.
      submittedData: [] 
    };
  }

  // This method handles changes for all input types (text, select, checkbox, radio).
  handleChange = (event) => {
    // It destructures properties from the event target to determine the input type.
    const { name, value, type, checked } = event.target;
    this.setState({
      // It uses a computed property name to update the state.
      // The value is `checked` for checkboxes and `value` for other inputs.
      [name]: type === "checkbox" ? checked : value
    });
  };

  // This method is called when the form is submitted.
  handleSubmit = (event) => {
    // It prevents the default form submission behavior.
    event.preventDefault();

    // It creates a new object with the current form data.
    const newEntry = {
      accessoryName: this.state.accessoryName,
      description: this.state.description,
      category: this.state.category,
      brand: this.state.brand,
      // Converts the boolean `available` state to a string.
      available: this.state.available ? "Yes" : "No",
      warranty: this.state.warranty
    };

    // It updates the state by adding the new entry to the `submittedData` array.
    this.setState((prevState) => ({
      submittedData: [...prevState.submittedData, newEntry],
      // It then resets all form fields to their initial empty values.
      accessoryName: "",
      description: "",
      category: "",
      brand: "",
      available: false,
      warranty: ""
    }));
  };

  // The render method defines the component's UI.
  render() {
    // A dictionary to store the brand options based on the selected category.
    const brandOptions = {
      Electronics: ["Samsung", "Sony", "LG"],
      Fashion: ["Nike", "Adidas", "Puma"],
      Furniture: ["Ikea", "Godrej", "Urban Ladder"]
    };

    return (
      <div className="container my-5 text-start">
        <div className="card shadow-sm mx-auto p-4" style={{ maxWidth: '800px' }}>
          <h2 className="text-start mb-4">Accessories Form</h2>
          {/* The form with an onSubmit handler. */}
          <form onSubmit={this.handleSubmit}>
            {/* Accessory Name input field. */}
            <div className="mb-3 text-start">
              <label className="form-label">Accessory Name</label>
              <input
                type="text"
                className="form-control"
                name="accessoryName"
                // The value is controlled by the state.
                value={this.state.accessoryName}
                // The onChange event is handled by the handleChange method.
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Description textarea field. */}
            <div className="mb-3 text-start">
              <label className="form-label">Description</label>
              <textarea
                className="form-control"
                name="description"
                value={this.state.description}
                onChange={this.handleChange}
                required
              ></textarea>
            </div>

            {/* Category select dropdown. */}
            <div className="mb-3 text-start">
              <label className="form-label">Category</label>
              <select
                className="form-select"
                name="category"
                value={this.state.category}
                onChange={this.handleChange}
                required
              >
                <option value="">Select Category</option>
                <option value="Electronics">Electronics</option>
                <option value="Fashion">Fashion</option>
                <option value="Furniture">Furniture</option>
              </select>
            </div>

            {/* Brand radio buttons, which are dynamically generated based on the selected category. */}
            <div className="mb-3 text-start">
              <label className="form-label d-block">Brand</label>
              {/* This section only renders if a category has been selected. */}
              {this.state.category &&
                brandOptions[this.state.category].map((brand, index) => (
                  <div className="form-check" key={index}>
                    <input
                      className="form-check-input"
                      type="radio"
                      name="brand"
                      value={brand}
                      checked={this.state.brand === brand}
                      onChange={this.handleChange}
                      required
                    />
                    <label className="form-check-label">{brand}</label>
                  </div>
                ))}
            </div>

            {/* Available checkbox. */}
            <div className="mb-3 text-start form-check">
              <input
                className="form-check-input"
                type="checkbox"
                name="available"
                // The `checked` property is used for checkboxes.
                checked={this.state.available}
                onChange={this.handleChange}
              />
              <label className="form-check-label">Available in Stock</label>
            </div>

            {/* Warranty number input field. */}
            <div className="mb-3 text-start">
              <label className="form-label">Warranty (in years)</label>
              <input
                type="number"
                className="form-control"
                name="warranty"
                value={this.state.warranty}
                onChange={this.handleChange}
                required
              />
            </div>

            <button type="submit" className="btn btn-primary">
              Submit
            </button>
          </form>

          {/* This table displays the submitted data and only renders if there's at least one submission. */}
          {this.state.submittedData.length > 0 && (
            <div className="mt-5">
              <h3 className="text-start">Submitted Accessories</h3>
              <table className="table table-bordered table-striped mt-3">
                <thead className="table-dark">
                  <tr>
                    <th>SL.No</th>
                    <th>Accessory Name</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Brand</th>
                    <th>Available</th>
                    <th>Warranty</th>
                  </tr>
                </thead>
                <tbody>
                  {/* It maps through the submittedData array to create a new row for each entry. */}
                  {this.state.submittedData.map((item, index) => (
                    <tr key={index}>
                      <td>{index+1}</td>
                      <td>{item.accessoryName}</td>
                      <td>{item.description}</td>
                      <td>{item.category}</td>
                      <td>{item.brand}</td>
                      <td>{item.available}</td>
                      <td>{item.warranty}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          )}
        </div>
      </div>
    );
  }
}

export default AccessoriesForm;