import React, { Component } from 'react';

// This is a React class component for a movie form.
class MovieForm extends Component {
  // The constructor initializes the component's state.
  constructor(props) {
    super(props);
    console.log("constructor executed");
    this.state = {
      // The `movies` array will store all submitted movie data.
      movies: [],
      // State for individual form input fields.
      movieTitle: '',
      director: '',
      releaseYear: '',
      genre: 'Action',
      rating: '1',
      description: '',
      // State for the checkbox inputs.
      streamingPlatforms: {
        Netflix: false,
        AmazonPrime: false,
        disneyPlus: false,
        others: false,
      }
    };
  }

  // Lifecycle method: Called before the render method, a good place to update state based on props.
  static getDerivedStateFromProps(props, state) {
    console.log("static getDerivedStateFromProps executed");
    return null;
  }

  // Lifecycle method: Called after the component is rendered for the first time.
  // Useful for fetching data or setting up subscriptions.
  componentDidMount() {
    console.log("componentDidMount executed");
    // You could fetch data here if needed
  }

  // Lifecycle method: Called before rendering when new props or state are received.
  // Can be used for performance optimization by returning false.
  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate executed");
    // This method is useful for performance optimization.
    // For this example, we always return true.
    return true;
  }

  // Lifecycle method: Called right before the DOM is updated.
  // It's useful for capturing information from the DOM before it changes.
  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log("getSnapshotBeforeUpdate executed");
    // This method is called right before the DOM is updated.
    // It's useful for capturing information from the DOM.
    return null;
  }

  // Lifecycle method: Called after the component's updates are flushed to the DOM.
  // Useful for side effects after an update.
  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log("componentDidUpdate executed");
  }

  // Lifecycle method: Called before the component is unmounted and destroyed.
  // Useful for cleanup tasks like removing event listeners.
  componentWillUnmount() {
    console.log("componentWillUnmount executed");
  }

  // This method handles changes for all controlled inputs.
  handleInputChange = (e) => {
    const { name, value, type, checked } = e.target;
    // Checks if the input is a checkbox to handle its value correctly.
    if (type === 'checkbox') {
      this.setState(prevState => ({
        streamingPlatforms: {
          ...prevState.streamingPlatforms,
          [name]: checked,
        }
      }));
    } else {
      // Updates the state for other input types.
      this.setState({ [name]: value });
    }
  }

  // This method handles the form submission.
  handleSubmit = (e) => {
    // Prevents the default form behavior (page reload).
    e.preventDefault();
    const { movieTitle, director, releaseYear, genre, rating, description, streamingPlatforms } = this.state;
    // Creates a new movie object from the state.
    const newMovie = {
      title: movieTitle,
      director,
      releaseYear,
      genre,
      rating,
      description,
      // Filters the streamingPlatforms object to get only the platforms that are checked.
      streamingPlatforms: Object.keys(streamingPlatforms).filter(key => streamingPlatforms[key])
    };

    // Adds the new movie object to the `movies` array and resets the form.
    this.setState(prevState => ({
      movies: [...prevState.movies, newMovie],
      // Reset form fields
      movieTitle: '',
      director: '',
      releaseYear: '',
      genre: 'Action',
      rating: '1',
      description: '',
      streamingPlatforms: {
        Netflix: false,
        AmazonPrime: false,
        disneyPlus: false,
        others: false,
      }
    }));
  }

  // The render method defines the component's UI.
  render() {
    console.log("render executed");
    const { movieTitle, director, releaseYear, genre, rating, description, streamingPlatforms, movies } = this.state;

    return (
      <div className="container mt-5 text-start">
        <div className="card mb-4">
          <div className="card-body">
            <h5 className="card-title">Add Movie</h5>
            {/* The form with an onSubmit handler. */}
            <form onSubmit={this.handleSubmit}>
              {/* Input for Movie Title, controlled by state. */}
              <div className="mb-3">
                <label htmlFor="movieTitle" className="form-label">Movie Title</label>
                <input
                  type="text"
                  className="form-control"
                  id="movieTitle"
                  name="movieTitle"
                  value={movieTitle}
                  onChange={this.handleInputChange}
                  required
                />
              </div>
              {/* Other input fields, all controlled by state. */}
              <div className="mb-3">
                <label htmlFor="director" className="form-label">Director</label>
                <input
                  type="text"
                  className="form-control"
                  id="director"
                  name="director"
                  value={director}
                  onChange={this.handleInputChange}
                  required
                />
              </div>
              <div className="mb-3">
                <label htmlFor="releaseYear" className="form-label">Release Year</label>
                <input
                  type="number"
                  className="form-control"
                  id="releaseYear"
                  name="releaseYear"
                  value={releaseYear}
                  onChange={this.handleInputChange}
                  required
                />
              </div>
              {/* Select dropdown for Genre. */}
              <div className="mb-3">
                <label htmlFor="genre" className="form-label">Genre</label>
                <select
                  className="form-select"
                  id="genre"
                  name="genre"
                  value={genre}
                  onChange={this.handleInputChange}
                >
                  <option value="Action">Action</option>
                  <option value="Comedy">Comedy</option>
                  <option value="Drama">Drama</option>
                  <option value="Sci-Fi">Sci-Fi</option>
                  <option value="Horror">Horror</option>
                </select>
              </div>
              {/* Dynamically generated radio buttons for Rating. */}
              <div className="mb-3">
                <label className="form-label d-block">Rating</label>
                {[1, 2, 3, 4, 5].map(r => (
                  <div className="form-check form-check-inline" key={r}>
                    <input
                      className="form-check-input"
                      type="radio"
                      name="rating"
                      id={`rating${r}`}
                      value={r}
                      checked={rating === String(r)}
                      onChange={this.handleInputChange}
                    />
                    <label className="form-check-label" htmlFor={`rating${r}`}>
                      {r}
                    </label>
                  </div>
                ))}
              </div>
              {/* Textarea for Description. */}
              <div className="mb-3">
                <label htmlFor="description" className="form-label">Description</label>
                <textarea
                  className="form-control"
                  id="description"
                  name="description"
                  rows="3"
                  value={description}
                  onChange={this.handleInputChange}
                ></textarea>
              </div>
              {/* Checkboxes for Streaming Platforms. */}
              <div className="mb-3">
                <label className="form-label d-block">Available on Streaming Platforms</label>
                <div className="form-check form-check-inline">
                  <input
                    className="form-check-input"
                    type="checkbox"
                    id="Netflix"
                    name="Netflix"
                    checked={streamingPlatforms.Netflix}
                    onChange={this.handleInputChange}
                  />
                  <label className="form-check-label" htmlFor="Netflix">Netflix</label>
                </div>
                <div className="form-check form-check-inline">
                  <input
                    className="form-check-input"
                    type="checkbox"
                    id="AmazonPrime"
                    name="AmazonPrime"
                    checked={streamingPlatforms.AmazonPrime}
                    onChange={this.handleInputChange}
                  />
                  <label className="form-check-label" htmlFor="Amazon Prime">Amazon Prime</label>
                </div>
                <div className="form-check form-check-inline">
                  <input
                    className="form-check-input"
                    type="checkbox"
                    id="disneyPlus"
                    name="disneyPlus"
                    checked={streamingPlatforms.disneyPlus}
                    onChange={this.handleInputChange}
                  />
                  <label className="form-check-label" htmlFor="disneyPlus">Disney+</label>
                </div>
                <div className="form-check form-check-inline">
                  <input
                    className="form-check-input"
                    type="checkbox"
                    id="others"
                    name="others"
                    checked={streamingPlatforms.others}
                    onChange={this.handleInputChange}
                  />
                  <label className="form-check-label" htmlFor="others">Others</label>
                </div>
              </div>
              {/* Submit button. */}
              <button type="submit" className="btn btn-primary">Add Movie</button>
            </form>
          </div>
        </div>

        {/* The table of submitted movies, conditionally rendered only if there are movies in the array. */}
        {movies.length > 0 && (
          <div className="mt-4">
            <h4>Added Movies</h4>
            <table className="table table-striped">
              <thead>
                <tr>
                  <th>Title</th>
                  <th>Director</th>
                  <th>Release Year</th>
                  <th>Genre</th>
                  <th>Rating</th>
                  <th>Available on Streaming Platforms</th>
                </tr>
              </thead>
              <tbody>
                {/* Maps through the `movies` array to create a new table row for each movie. */}
                {movies.map((movie, index) => (
                  <tr key={index}>
                    <td>{movie.title}</td>
                    <td>{movie.director}</td>
                    <td>{movie.releaseYear}</td>
                    <td>{movie.genre}</td>
                    <td>{movie.rating}</td>
                    <td>
                      {/* Displays the streaming platforms as a list within the cell. */}
                      <ul className="list-unstyled">
                        {movie.streamingPlatforms.map((platform, i) => (
                          <li key={i}>{platform}</li>
                        ))}
                      </ul>
                    </td>
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

export default MovieForm;
