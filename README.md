# multi-ws
Web service aggregating different endpoints in a multithreaded fashion

[![Build Status](https://travis-ci.org/adarrivi/multi-ws.png)](https://travis-ci.org/adarrivi/multi-ws)

### Todo list
- [ ] Create a web service that aggregates the result of two different endpoints using an http client in parallel
- [ ] Use [Netflix's Hystrix](https://github.com/Netflix/Hystrix/wiki) to monitor and speed things up when the endpoints fail
- [ ] Having tests for everything: unit, integration and functional
- [ ] Use the [Multi thread sf4j logging](https://github.com/adarrivi/multi-thread-slf4j-logging) to log the same UUID generated request id in the different threads
- [ ] Create a small UI showing the results
- [ ] In an embedded container. Maybe even try with [Dropwizard](http://dropwizard.io/)?
- [ ] Add caching with different timeouts for the endpoints, and getting the shortest in the general request
