import React, { Component, createRef } from "react";

// This component uses a controlled form, where input values are managed by React state.
class FlightBookingControlled extends Component {
  constructor(props) {
    super(props);
    this.state = {
      passengerName: "",
      email: "",
      gender: "Male",
      mealPreference: "Veg",
      specialRequest: "",
      // An array to store all submitted form data.
      submittedData: [], 
    };
  }

  // This method handles changes for all controlled inputs.
  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({
      ...this.state,
      [name]: value,
    });
  };

  // This method handles the form submission.
  handleSubmit = (e) => {
    e.preventDefault();

    // Creates an object with the current form data from the state.
    const newEntry = {
      passengerName: this.state.passengerName,
      email: this.state.email,
      gender: this.state.gender,
      mealPreference: this.state.mealPreference,
      specialRequest: this.state.specialRequest,
    };

    // Adds the new entry to the submittedData array and resets the form state.
    this.setState((prevState) => ({
      ...prevState,
      submittedData: [...prevState.submittedData, newEntry],
      passengerName: "",
      email: "",
      gender: "Male",
      mealPreference: "Veg",
      specialRequest: "",
    }));
  };

  render() {
    return (
      <div className="container mt-5 text-start ">
        <h3 className="mb-4">Controlled Flight Booking Form</h3>
        <form onSubmit={this.handleSubmit}>
          {/* Each input's value is controlled by the state and updated by `handleChange`. */}
          <div className="mb-3">
            <label className="form-label">Passenger Name</label>
            <input
              type="text"
              className="form-control"
              name="passengerName"
              value={this.state.passengerName}
              onChange={this.handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Email</label>
            <input
              type="email"
              className="form-control"
              name="email"
              value={this.state.email}
              onChange={this.handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Gender</label>
            <div>
              <div className="form-check form-check-inline">
                <input
                  type="radio"
                  className="form-check-input"
                  name="gender"
                  value="Male"
                  checked={this.state.gender === "Male"}
                  onChange={this.handleChange}
                />
                <label className="form-check-label">Male</label>
              </div>
              <div className="form-check form-check-inline">
                <input
                  type="radio"
                  className="form-check-input"
                  name="gender"
                  value="Female"
                  checked={this.state.gender === "Female"}
                  onChange={this.handleChange}
                />
                <label className="form-check-label">Female</label>
              </div>
            </div>
          </div>

          <div className="mb-3">
            <label className="form-label">Meal Preference</label>
            <select
              className="form-select"
              name="mealPreference"
              value={this.state.mealPreference}
              onChange={this.handleChange}
            >
              <option value="Veg">Veg</option>
              <option value="Non-Veg">Non-Veg</option>
            </select>
          </div>

          <div className="mb-3">
            <label className="form-label">Special Request</label>
            <textarea
              className="form-control"
              name="specialRequest"
              value={this.state.specialRequest}
              onChange={this.handleChange}
            />
          </div>

          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </form>

        {/* This table displays submitted data and only appears if there is any. */}
        {this.state.submittedData.length > 0 && (
          <div className="mt-4">
            <table className="table table-bordered">
              <thead className="table-light">
                <tr>
                  <th>SL.No</th>
                  <th>Passenger Name</th>
                  <th>Email</th>
                  <th>Gender</th>
                  <th>Meal Preference</th>
                  <th>Special Request</th>
                </tr>
              </thead>
              <tbody>
                {this.state.submittedData.map((entry, index) => (
                  <tr key={index}>
                    <td>{index + 1}</td>
                    <td>{entry.passengerName}</td>
                    <td>{entry.email}</td>
                    <td>{entry.gender}</td>
                    <td>{entry.mealPreference}</td>
                    <td>{entry.specialRequest}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

// This component uses an uncontrolled form, where input values are managed by the DOM.
class FlightBookingUncontrolled extends Component {
  constructor(props) {
    super(props);

    // Creates references to DOM elements instead of using state.
    this.flightNumberRef = createRef();
    this.sourceRef = createRef();
    this.destinationRef = createRef();
    this.dateRef = createRef();
    this.termsRef = createRef();

    this.state = {
      // The state is only used to store the list of submitted bookings.
      bookings: [], 
    };
  }

  // This method gets input values directly from the DOM using the refs.
  handleSubmit = (e) => {
    e.preventDefault();

    // Accesses the current value of each input through its ref.
    const newBooking = {
      flightNumber: this.flightNumberRef.current.value,
      source: this.sourceRef.current.value,
      destination: this.destinationRef.current.value,
      travelDate: this.dateRef.current.value,
      termsAccepted: this.termsRef.current.checked,
    };

    // Adds the new booking to the state's `bookings` array.
    this.setState((prevState) => ({
      bookings: [...prevState.bookings, newBooking],
    }));

    // Resets the form fields by directly manipulating the DOM values.
    this.flightNumberRef.current.value = "";
    this.sourceRef.current.value = "";
    this.destinationRef.current.value = "";
    this.dateRef.current.value = "";
    this.termsRef.current.checked = false;
  };

  render() {
    return (
      <div className="container mt-5 text-start">
        <h3 className="mb-4">Uncontrolled Flight Booking Form</h3>
        <form onSubmit={this.handleSubmit}>
          {/* The `ref` prop connects the input to the corresponding reference. */}
          <div className="mb-3">
            <label className="form-label">Flight Number</label>
            <input type="text" className="form-control" ref={this.flightNumberRef} />
          </div>
          <div className="mb-3">
            <label className="form-label">Source</label>
            <input type="text" className="form-control" ref={this.sourceRef} />
          </div>
          <div className="mb-3">
            <label className="form-label">Destination</label>
            <input type="text" className="form-control" ref={this.destinationRef} />
          </div>
          <div className="mb-3">
            <label className="form-label">Travel Date</label>
            <input type="date" className="form-control" ref={this.dateRef} />
          </div>
          <div className="form-check mb-3">
            <input type="checkbox" className="form-check-input" ref={this.termsRef} />
            <label className="form-check-label">Terms Accepted</label>
          </div>
          <button type="submit" className="btn btn-primary">Submit</button>
        </form>

        {/* This section displays the list of uncontrolled form submissions. */}
        {this.state.bookings.length > 0 && (
          <div className="mt-4">
            <h5>All Flight Bookings</h5>
            {this.state.bookings.map((booking, index) => (
              <div className="card mt-3" key={index}>
                <div className="card-body">
                  <h6 className="card-title">Booking {index + 1}</h6>
                  <p><strong>Flight Number:</strong> {booking.flightNumber}</p>
                  <p><strong>Source:</strong> {booking.source}</p>
                  <p><strong>Destination:</strong> {booking.destination}</p>
                  <p><strong>Travel Date:</strong> {booking.travelDate}</p>
                  <p><strong>Terms Accepted:</strong> {booking.termsAccepted ? "Yes" : "No"}</p>
                </div>
              </div>
            ))}
          </div>
        )}
      </div>
    );
  }
}

// This is a parent component that renders both controlled and uncontrolled forms.
const FlightTicket = () => {
  return (
    <div >
      <FlightBookingControlled/>
      <FlightBookingUncontrolled />
    </div>
  );
};

export default FlightTicket;
