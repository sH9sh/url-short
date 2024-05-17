
This is a URL shortening application that can be deployed on Google Cloud Platform. It was built by our apprentice team bounty hunters and I during our first few months working at Zinkworks, and at a later date we deployed to GCP. It was written in Java with the Spring framework. It is deployed to GCP using continuous deployment with Cloud Run, Cloud Build and Cloud SQL.

To use the application, please have Postman installed.

1. Run application.
2. Open Postman, create Post request and enter <u>http://localhost:8080/api/v1/BountyURL</u>
3. In the body, select raw and enter your URL.

<b>To deploy on Google Cloud Platform</b>

1. Build docker image.
2. Tag and push image to gcr.io / artifact registry.
3. Create postgres instance.
4. In cloud build, connect Github repository.
5. Create trigger that will activate the continuous deployment.
6. Add roles to IAM account: Cloud Run Admin, Cloud SQL Admin, Cloud SQL Client, Cloud Build Connection Admin.
7. Ensure these are also enabled in Cloud Build Settings.
8. Make a change and push to your repository.
9. Follow steps for using application above but replace 'http://localhost:8080' with generated Cloud Run URL.

<b>Noted Issues</b>

In event of errors related to 'Failure to set IAM policy' or 'Unable to generate ephemeral certificate'. This may be due to restrictions set by an account's organisation policies.
