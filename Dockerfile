FROM gradle
USER root
RUN git clone https://github.com/Bpazy/WeatherFor
WORKDIR WeatherFor
RUN gradle fatJar
RUN echo "Asia/Shanghai" > /etc/timezone;
CMD ["java", "-cp", "./libs", "-jar", "./build/libs/weatherfor-1.0.jar"]
