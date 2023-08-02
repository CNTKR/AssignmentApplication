<h1>Weather Forecast Application</h1>

<p>This is a simple command-line application that fetches weather forecast data for London using the OpenWeatherMap API. The user can choose from different options to get specific weather information based on the date.</p>

<h3>Getting Started</h3>
<h2>Prerequisites</h2>
<ul>
  <li>Java Development Kit (JDK) 8 or later</li>
 <li>Internet connection (to fetch weather data from the API</li>
</ul>
<h3>
  How to Run
</h3>
<ul>
  <li>Clone this repository to your local machine or download the source code.</li>
  <li>Open a terminal (command prompt) and navigate to the project directory.</li>
  <li>Compile the Java source code using the following command:</li>
</ul>
javac -cp ".:json.jar" com/example/demo/AssignmentApplication.java
<h3>1.Run the compiled program using the following command:</h3>
java -cp ".:json.jar" com.example.demo.AssignmentApplication
<h3>Usage
Upon running the application, you will see the following menu:</h3>
1. Get weather<br>
2. Get wind speed<br>
3. Get pressure<br>
0. Exit<br>
<ul>
  <li>To get specific weather information, follow these steps:</li>
  <li>Enter the corresponding number for the option you want (1, 2, 3, or 0 to exit).</li>
  <li>If you choose option 1 or 2, the program will prompt you to enter a date in the format "YYYY-MM-DD".</li>
  <li>The program will fetch weather data for London from the API and display the requested information based on the input date.</li>
  <li>If the entered date is not within the available forecast data, the program will notify you that there is no weather data available for that date.</li>
</ul>

<h2>Example</h2>
Here's an example of how to use the application:
1. Get weather
2. Get wind speed
3. Get pressure
0. Exit<br>
<Enter option: 1
Enter date (YYYY-MM-DD): 2023-08-02
Weather: Clouds
Temperature: 278.76 degrees
Humidity: 100%
Enter option: 2
Enter date (YYYY-MM-DD): 2023-08-02
Wind speed: 1.6 mph
Enter option: 3
Enter date (YYYY-MM-DD): 2023-08-02
Pressure: 1031.934 hPa
Enter option: 0
<h2>Notes</h2>
The weather data fetched from the provided API URL (https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22) is a sample data and might not always be up to date or accurate.
For real-time weather data, consider using a valid API URL with a proper API key provided by the weather service provider.


