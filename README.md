WeatherFor
======
SMS or email to remind the weather at regular time. 

## Attention
Only support chinese cell phone number.

## Usage
```
{
  "nums": [
    {
      "num": "18600000000", // cell phone number
      "location": "nanjing" // cell phone number's location
    }
  ],
  "hour": 12, // Start time.
  "minute": 12,
  "second": 30,
  "interval": 24 // Interval time(/h)
}
```

## Develop
Implement interface `WeatherClient` to define your weather server.   
Implement interface `Message` to define your sms or email setting.   

Then `App app = new App()` and `app.addSend(new YourMessage())` in `main(String... args)` method.  
You can define your `WeatherClient` and `Message` interaction logic in method `App.run()`.  

Finally, execute `app.run()`.