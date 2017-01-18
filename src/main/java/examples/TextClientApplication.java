package examples;




import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.model.AIContext;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import java.io.Serializable;
import java.util.List;


public class TextClientApplication implements Serializable {




    private  AIDataService dataService;

    public TextClientApplication(){

	    String ApiKey="7c2213d95cb741309c7ae4c2bd800ce1";
        AIConfiguration configuration= new AIConfiguration(ApiKey);
        dataService = new AIDataService(configuration);

    }

	public AIResponse responder(String line, List<AIContext> context) {

        //System.out.println("hey");

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
