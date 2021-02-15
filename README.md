TO EXECUTE TESTS

./gradlew runTests

./gradlew runTests -DdefaultTimeout=5 -Dbrowser=firefox

We can also define courgette parameters in run command, for example we can increase rerun attempts count, as it is 1 per default:

./gradlew runTests -Dcucumber.tags="@ContactForm" -DdefaultTimeout=5 -Dcourgette.rerunAttempts=2

NOTE: there is no point in changing remote and os properties at the moment, as they are not properly configured in this project yet.

Scenarios

NOTE: Validation second scenario is meant to fail to show rerun option possibility and setup.

Report repo - build/courgette-report
