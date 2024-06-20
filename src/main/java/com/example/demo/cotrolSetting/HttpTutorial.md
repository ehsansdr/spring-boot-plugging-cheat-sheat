response-entity:       

[spring response entity](https://www.baeldung.com/spring-response-entity)

http verb:          
[HTTP Methods OPTIONS](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/OPTIONS)

[HTTP Headers](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers    
http status code: 
if the method called we can get this status 

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)

like:
    
    @GetMapping("/d/d")
    @ResponseStatus(HttpStatus.)
    public String getMapping(){
        return "getMapping is called";
    }



[HTTP status code](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/OPTIONS)