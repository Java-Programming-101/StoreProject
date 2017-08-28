const DEVE_ENVIRONMENT = 0;
const TEST_ENVIRONMENT = 1;
const PROD_ENVIRONMENT = 2;

const selectedEnvironment = DEVE_ENVIRONMENT;

const developmentConfig = {
    "imageURL":"http://localhost:3000/images_v1/",
    "apiURL": "http://localhost:8088"
};

const testingConfig = {
    "imageURL":"http://localhost:3000/images_v1/",
    "apiURL": "http://localhost:8088"
};

const productionConfig = {
    "imageURL":"http://localhost:3000/images_v1/",
    "apiURL": "http://localhost:8088"
};

const environments = [developmentConfig,testingConfig,productionConfig];

export function getEnvironment() {
    return environments[selectedEnvironment];
}
