node {

	stage ('SCM checkout'){

		git "https://github.com/ravnitkr/NPW_Automation"

		}

	stage ('Build'){

    	dir(“NPW_Automation) {

	   sh “gradle build"

       }

		}

}