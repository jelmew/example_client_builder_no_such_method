package nl.jelmervanamen;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.junit.jupiter.api.Test;

import static nl.jelmervanamen.Function.CONNECTION_STRING;

public class WorkingBlobServiceClientBuilder {

    @Test
    public void workingBlobClientBuilder() {
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(CONNECTION_STRING)
                                                                            .buildClient();
        blobServiceClient.listBlobContainers()
                         .forEach(blobContainerItem -> System.out.println(blobContainerItem.getName()));
    }

}
