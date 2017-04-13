WeatherFor
======
SMS or email to remind the weather at regular time. 

## Attention
Only support chinese cell phone number.

## Usage
```
# weatherFor.json
{
  "nums": [
    {
      "num": "18612342345",
      "location": "nanjing",
      "cron": "* * 7 * * ?"
    }
  ]
}

# alidayu.json
{
  "appKey": "your appKey",
  "appSecret": "your appSecret"
}
```
[cron expression help](http://www.quartz-scheduler.org/documentation/quartz-2.2.x/tutorials/tutorial-lesson-06.html)
## Develop
Implement interface `WeatherClient` to define your weather server.   
Implement interface `Message` to define your sms or email setting.   

Then `App app = new App()` and `app.addSend(new YourMessage())` in `main(String... args)` method.  
You can define your `WeatherClient` and `Message` interaction logic in method `App.run()`.  

Finally, execute `app.run()`.

### Docker
```
mkdir WeatherFor
vim weatherFor.json  // 你的weatherFor配置文件
vim alidayu.json     // 你的阿里大于配置文件
docker run -d -v ./weatherFor.json:/home/gradle/WeatherFor/weatherFor.json \
              -v ./alidayu.json:/home/gradle/WeatherFor/weatherFor.json \
              hanziyuan08/weatherfor
```