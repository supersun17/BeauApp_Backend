package com.beauapp.server.utilities;





import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fluentinterface.ReflectionBuilder;
import com.fluentinterface.builder.Builder;

public class JsonResponse {
    private String value;

    public JsonResponse(String value){
    	this.value=value;
    }
    
    @JsonValue
    @JsonRawValue
	public String getValue() {
		return value;
	}
    
 
    
    public static JsonResponseBuilder create() {
		return ReflectionBuilder.implementationFor(JsonResponseBuilder.class).create();
	}
	public interface JsonResponseBuilder extends Builder<JsonResponse> {
		public JsonResponseBuilder withValue(String value);
	
	
	}
    
}
