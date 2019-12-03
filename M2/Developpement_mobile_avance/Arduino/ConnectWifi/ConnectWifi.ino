#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>

// WiFi parameters
const char* ssid = "Panda_mobil";
const char* password = "11PandaPomme";

void setup(void)
{
  // Start Serial
  Serial.begin(115200);

  // Set WiFi to station mode and disconnect from an AP if it was previously connected
  WiFi.mode(WIFI_STA);
  WiFi.disconnect();
  delay(100);
  
  // Connect to WiFi
  WiFi.begin(ssid, password);
  Serial.println("");
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected");
  
  // Print the IP address
  Serial.println(WiFi.localIP());

  
}

void loop()
{
  // Check WiFi connection status
  if (WiFi.status() == WL_CONNECTED)
  {
    HTTPClient http; // Declare an object of class HTTPClient
    
    http.begin("http://jsonplaceholder.typicode.com/users/1"); // Specify request destination
    int httpCode = http.GET(); // Send the request
     
    // Check the returning code
    if (httpCode > 0)
    {
      String payload = http.getString(); // Get the request response payload
      Serial.println(payload); // Print the response payload
    }
    else
    {
      Serial.println("nul");
    }
     
    http.end(); // Close connection 
  }
   
  delay(30000); 
}
