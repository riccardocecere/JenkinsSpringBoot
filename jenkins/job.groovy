// import jenkins.model.Jenkins
// def jenkinsInstance = Jenkins.getInstance()
// def job = jenkinsInstance.createProject(hudson.model.FreeStyleProject, "SpringBootApplicationDemo")
// job.setDescription("This is a Jenkins job created with Groovy script")

// repository='https://github.com/riccardocecere/JenkinsSpringBoot.git'
// job.scm = new hudson.plugins.git.GitSCM(repository) 
// job.scm.branches = [new BranchSpec('*/main')]
// job.save()



// imports
import hudson.plugins.git.*
import hudson.plugins.git.extensions.*
import hudson.plugins.git.extensions.impl.*
import jenkins.model.Jenkins

// parameters
def jobParameters = [
  name:          'DEMO',
  description:   'This is a Jenkins job created with Groovy script',
  repository:    'https://github.com/riccardocecere/JenkinsSpringBoot.git',
  branch:        '*/main',

]

// define repo configuration
def branchConfig                =   [new BranchSpec(jobParameters.branch)]
def userConfig                  =   [new UserRemoteConfig(jobParameters.repository, null, null, jobParameters.credentialId)]
def cleanBeforeCheckOutConfig   =   new CleanBeforeCheckout()
def sparseCheckoutPathConfig    =   new SparseCheckoutPaths([new SparseCheckoutPath("Jenkinsfile")])
def cloneConfig                 =   new CloneOption(true, true, null, 3)
def extensionsConfig            =   [cleanBeforeCheckOutConfig,sparseCheckoutPathConfig,cloneConfig]
def scm                         =   new GitSCM(userConfig, branchConfig, false, [], null, null, null)

// define SCM flow
def flowDefinition = new org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition(scm, "Jenkinsfile")

// set lightweight checkout
flowDefinition.setLightweight(true)

// get Jenkins instance
Jenkins jenkins = Jenkins.getInstance()

// create the job
def job = new org.jenkinsci.plugins.workflow.job.WorkflowJob(jenkins,jobParameters.name)

// define job type
job.definition = flowDefinition

// set job description
job.setDescription(jobParameters.description)

// save to disk
jenkins.save()
jenkins.reload()