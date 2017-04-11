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
      "num": "18612342345",
      "location": "nanjing",
      "cron": "* * 7 * * ?"
    }
  ]
}
```
[cron expression help](http://www.quartz-scheduler.org/documentation/quartz-2.2.x/tutorials/tutorial-lesson-06.html)
## Develop
Implement interface `WeatherClient` to define your weather server.   
Implement interface `Message` to define your sms or email setting.   

Then `App app = new App()` and `app.addSend(new YourMessage())` in `main(String... args)` method.  
You can define your `WeatherClient` and `Message` interaction logic in method `App.run()`.  

Finally, execute `app.run()`.
