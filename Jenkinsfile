pipeline {
	agent any

	environment {
		ALLURE_RESULTS = "target/allure-results"
	}


	stages {
		stage('Checkout') {
			steps {
				checkout scm
			}
		}

		stage('Build Docker Image') {
			steps {
				sh 'docker build -t java-core-part-3-tests .'
			}
		}

		stage('Run Tests in Docker') {
			steps {
				sh 'docker run --name java-core-part-3-tests-container java-core-part-3-tests || true'
			}
		}

		stage('Copy Allure Results') {
			steps {
				sh 'docker cp java-core-part-3-tests-container:/Java-Core-Part-3/target/allure-results ./target/allure-results'
			}
		}

		stage('Publish Allure Report') {
			steps {
				allure([
					includeProperties: false,
					jdk: '',
					results: [[path: "${ALLURE_RESULTS}"]]
				])
			}
		}

	}


	post {
		always {
			sh 'docker rm -f java-core-part-3-tests-container || true'
		}
	}
}