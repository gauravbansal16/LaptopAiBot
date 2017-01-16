package examples;




import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.model.AIContext;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.model.Result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Text client reads requests line by line
 * from stdandart input.
 */
public class TextClientApplication implements Serializable {


	/**
	 * Default exit code in case of error
	 */


    private  AIDataService dataService;

    public TextClientApplication(){

	    String ApiKey="7c2213d95cb741309c7ae4c2bd800ce1";
        AIConfiguration configuration= new AIConfiguration(ApiKey);
        dataService = new AIDataService(configuration);

    }

	public AIResponse responder(String line, List<AIContext> context) {

        System.out.println("hey");


        List<String> reply = new ArrayList<String>();
        AIResponse response=new AIResponse();

        try {
            AIRequest request = new AIRequest(line);
            request.setContexts(context);
            response = dataService.request(request);



        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }










}
