# Consumer Service

The Consumer Service exposes streams of BLE scan data to the end user.  This project provdies a sample client for connecting to the BluZone Cloud and accessing this Stream.

This repository provides two reference client implementations.  

1. samples/java-consumer-client is a Spring-Boot application and implements the Tyrus WebSocket Client
2. samples/wscat-consumer-client is a Node based, command line utility for accessing the WebSocket endpoint

The Java based client is useful for demonstrating integration in a B2B scenario while the wscat example provides a quick command-line testing capabilities.

### Getting Up and Running

This documentation assumes you have already registered for an account on the BluZone portal and have provisioned one or more BluFi devices.

![Locate API Token in the Portal](https://raw.githubusercontent.com/bluzone/consumer-service/master/docs/images/portal-api-access-screen.png)


1. Locate your API_TOKEN by logging into the portal and click on the "API Access" left-menu item.
2. The API_TOKEN value is the Web API Access - Web API Token.
3. The API_URL value is derived from the url of your portal.
