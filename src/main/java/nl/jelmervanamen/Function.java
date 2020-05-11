package nl.jelmervanamen;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.Optional;

public class Function {
    public static final String CONNECTION_STRING = "DUMMY_STRING";

    @FunctionName("HttpExample")
    public HttpResponseMessage run(@HttpTrigger(name = "req", methods = {HttpMethod.GET,
            HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
                                   final ExecutionContext context) throws Exception {
        context.getLogger()
               .info("Java HTTP trigger processed a request.");
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(CONNECTION_STRING)
                                                                            .buildClient();
        blobServiceClient.listBlobContainers()
                         .forEach(blobContainerItem -> System.out.println(blobContainerItem.getName()));
        return request.createResponseBuilder(HttpStatus.OK)
                      .build();

    }
}
