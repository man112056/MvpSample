# MVP Sample (Model-View-Presenter)

This project demonstrates the use of the MVP (Model-View-Presenter) architectural pattern in Android development.

## Structure

The project is organized into the following components:

### 1. **Contract**
This interface holds all the contracts (Model, View, Presenter) to define the communication between these components.

- **Model**: Handles the business logic and data retrieval.
    - `OnFinishedListener`: A callback to notify the presenter when data is ready.
    - `getNewData(onFinishedListener: OnFinishedListener)`: Fetches new data asynchronously.

- **View**: Responsible for displaying data and handling UI operations.
    - `showProgress()`: Displays a progress bar.
    - `hideProgress()`: Hides the progress bar and shows the text view.
    - `setString(newStr: String?)`: Updates the text view with the fetched data.

- **Presenter**: Acts as a mediator between Model and View.
    - `onButtonClickAction()`: Called when the button is clicked; triggers the fetching of new data from the model.
    - `onDestroy()`: Cleans up any references (if needed) when the view is destroyed.

```kotlin
interface Contract {
    interface Model {
        interface OnFinishedListener {
            fun onFinished(str: String?)
        }

        fun getNewData(onFinishedListener: OnFinishedListener)
    }

    interface View {
        fun showProgress()
        fun hideProgress()
        fun setString(newStr: String?)
    }

    interface Presenter {
        fun onButtonClickAction()
        fun onDestroy()
    }
}
