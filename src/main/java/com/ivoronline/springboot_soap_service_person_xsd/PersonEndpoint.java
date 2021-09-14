package com.ivoronline.springboot_soap_service_person_xsd;

import com.ivoronline.soap.GetPersonRequest;
import com.ivoronline.soap.GetPersonResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PersonEndpoint {

  private static final String NAMESPACE_URI = "http://ivoronline.com/soap";

  //=====================================================================================
  // GET PERSON
  //=====================================================================================
  @ResponsePayload
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
  public GetPersonResponse getPerson(@RequestPayload GetPersonRequest getPersonRequest) {

    //GET PERSON ID
    int id = getPersonRequest.getId();

    //CREATE GetPersonResponse
    GetPersonResponse getPersonResponse = new GetPersonResponse();
    if      (id==1) { getPersonResponse.setName("John");    }
    else if (id==2) { getPersonResponse.setName("Bill");    }
    else            { getPersonResponse.setName("Unknown"); }

    //RETURN GetPersonResponse
    return getPersonResponse;

	}

}

