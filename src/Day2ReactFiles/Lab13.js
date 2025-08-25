import React from 'react';

// This is a React class component.
class MarriageForm extends React.Component {
  // The constructor sets up the initial state for the form fields and submitted data.
  constructor(props) {
    super(props);
    this.state = {
      brideName: '',
      groomName: '',
      marriageDate: '',
      venue: '',
      // This state variable will hold the form data after submission.
      submittedData: null,
    };
  }

  // This method updates the state whenever an input field changes.
  handleChange = (e) => {
    // It uses the name and value from the input to update the corresponding state property.
    const { name, value } = e.target;
    this.setState({
      [name]: value,
    });
  };

  // This method is called when the form is submitted.
  handleSubmit = (e) => {
    // It prevents the page from reloading.
    e.preventDefault();
    const { brideName, groomName, marriageDate, venue } = this.state;
    // It saves the current form data into the submittedData state.
    this.setState({
      submittedData: {
        brideName,
        groomName,
        marriageDate,
        venue,
      },
    });
  };

  // The render method defines the component's UI.
  render() {
    // Destructuring state for easier access.
    const { brideName, groomName, marriageDate, venue, submittedData } = this.state;

    return (
      <div className="container mt-5">
        <div className="row justify-content-center">
          <div className="col-md-8">
            {/* The main form card. */}
            <div className="card mb-4">
              <div className="card-header bg-primary text-white text-center">
                <h2>Marriage Form</h2>
              </div>
              <div className="card-body">
                {/* The form element with an onSubmit handler. */}
                <form onSubmit={this.handleSubmit}>
                  <div className="form-group mb-3">
                    <label htmlFor="brideName" className="form-label">Bride Name</label>
                    <input
                      type="text"
                      className="form-control"
                      id="brideName"
                      name="brideName"
                      // The input value is controlled by the component's state.
                      value={brideName}
                      // The onChange event is handled by the handleChange method.
                      onChange={this.handleChange}
                      required
                    />
                  </div>
                  <div className="form-group mb-3">
                    <label htmlFor="groomName" className="form-label">Groom Name</label>
                    <input
                      type="text"
                      className="form-control"
                      id="groomName"
                      name="groomName"
                      value={groomName}
                      onChange={this.handleChange}
                      required
                    />
                  </div>
                  <div className="form-group mb-3">
                    <label htmlFor="marriageDate" className="form-label">Marriage Date</label>
                    <input
                      type="date"
                      className="form-control"
                      id="marriageDate"
                      name="marriageDate"
                      value={marriageDate}
                      onChange={this.handleChange}
                      required
                    />
                  </div>
                  <div className="form-group mb-3">
                    <label htmlFor="venue" className="form-label">Venue</label>
                    <input
                      type="text"
                      className="form-control"
                      id="venue"
                      name="venue"
                      value={venue}
                      onChange={this.handleChange}
                      required
                    />
                  </div>
                  <div className="d-grid mt-4">
                    <button type="submit" className="btn btn-primary">
                      Submit
                    </button>
                  </div>
                </form>
              </div>
            </div>

            {/* This section only renders if submittedData has a value (i.e., after form submission). */}
            {submittedData && (
              <div className="card">
                <div className="card-header bg-secondary text-white text-center">
                  <h3>Marriage Details</h3>
                </div>
                <div className="card-body">
                  <table className="table table-borderless">
                    <tbody>
                      <tr>
                        <th className="col-4">Bride Name:</th>
                        <td>{submittedData.brideName}</td>
                      </tr>
                      <tr>
                        <th>Groom Name:</th>
                        <td>{submittedData.groomName}</td>
                      </tr>
                      <tr>
                        <th>Date:</th>
                        <td>{submittedData.marriageDate}</td>
                      </tr>
                      <tr>
                        <th>Venue:</th>
                        <td>{submittedData.venue}</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            )}
          </div>
        </div>
      </div>
    );
  }
}

export default MarriageForm;