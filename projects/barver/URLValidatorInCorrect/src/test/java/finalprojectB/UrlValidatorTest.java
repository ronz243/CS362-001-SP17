/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;





/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

	   //Testing valid scheme,authority,port, expect True
	   System.out.println(urlVal.isValid("http://www.amazon.com"));

	   //Testing valid scheme,authority,port,and path expect True
       System.out.println(urlVal.isValid("https://www.amazon.com/index_2_4.html"));

       //Testing valid scheme,authority,port,path and  valid query expect True
       System.out.println(urlVal.isValid("http://www.amazon.com/t123??action=edit&mode=up"));

       //Testing valid scheme, invalid authority,port, and valid path expect false
       System.out.println(urlVal.isValid("https://www.a-.com/index_2_4.html"));

       //Testing invalid scheme,valid authority,valid port, expect false
       System.out.println(urlVal.isValid("hst://www.amazon.com/"));
	   
   }
   
   
   public void testYourFirstPartition()
   {
       System.out.println("Running first partition testing for ports");
	   UrlValidator urlVal = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);

	   //testing invalid ports
       if(!urlVal.isValid("http://www.yahoo.com:-2")&& !urlVal.isValid("http://www.bing.com:-100")&&
               !urlVal.isValid("http://www.yahoo.com:22e")&& !urlVal.isValid("http://www.bing.com:y44"))
           System.out.println("invalid port failed as expected");
       else{
           System.out.println("One invalid port passed, possible bug");
       }

       //testing valid ports
       if(urlVal.isValid("http://www.yahoo.com:100")&& urlVal.isValid("http://www.bing.com:10")&&
               urlVal.isValid("http://www.yahoo.com:20")&& urlVal.isValid("http://www.bing.com:44"))
           System.out.println("valid port passed as expected");
       else{
           System.out.println("One valid port failed, possible bug");
       }
   }
   
   public void testYourSecondPartition(){

       System.out.println("Running second partition testing for schemes");
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       // testing invalid schemes
       if (!urlVal.isValid("wht://www.google.com") && !urlVal.isValid("http:www.google.com")
               && !urlVal.isValid("http:/www.bing.com") && !urlVal.isValid("htttttp/www.yahoo.com")
               && !urlVal.isValid(":://www.google.com")) {
           System.out.println("invalid input schemes failed as expected");
       } else {
           System.out.println("atleast one invalid input scheme passed, possible bug");
       }

       // testing valid schemes
       if (urlVal.isValid("http://www.google.com") && urlVal.isValid("ftp://www.google.com")
               && urlVal.isValid("https://www.google.com")) {
           System.out.println("valid input schemes passed as expected");
       } else {
           System.out.println("valid input schemes failed indication of a possible bug");
       }
	   
   }

    public void testYourThirdPartition(){

        System.out.println("Running third partition testing for paths");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        //testing invalid Path
        if (!urlVal.isValid("http://www.google.com/....") &&
                !urlVal.isValid("http://www.google.com/..") &&
                !urlVal.isValid("http://www.google.com//..//"))
        {
            System.out.println("invalid path failed as expected");
        }
        else
        {
            System.out.println("One invalid path passed, possible bug");
        }

        //testing valid Path
        if (urlVal.isValid("http://www.bing.com/index") &&
                urlVal.isValid("http://www.yahoo.com/index/foo") &&
                urlVal.isValid("http://www.google.com/") &&
                urlVal.isValid("http://www.amazon.com/.") )
        {
            System.out.println("valid path passed as expected");
        }
        else
        {
            System.out.println("valid path failed possible bug");
        }

    }

    public void testYourFourthPartition() {
        System.out.println("Running fourth partition testing for authority");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        // invalid authority
        if (!urlVal.isValid("http://amazon.zmb") && urlVal.isValid("http://0.0.0.0")
                && !urlVal.isValid("http://gotcha.zmb.xyz") && !urlVal.isValid("http://.xyz")) {
            System.out.println("invalid authority failed as expected");
        } else {
            System.out.println("One invalid authority passed, possible bug");
        }

        // valid authority
        if (!urlVal.isValid("http://256.256.256.256") && urlVal.isValid("http://www.google.com")
                && urlVal.isValid("http://255.255.255.255")) {
            System.out.println("valid input authority passed as expected");
        } else {
            System.out.println("valid authority failed, possible bug");
        }

    }

    public void testYourFifthPartition(){
        System.out.println("Running fifth partition testing for query");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        //  testing valid query
        if (urlVal.isValid("http://www.amazon.com?action=view") && urlVal.isValid("http://www.amazon.com?action=edit&mode=up")){
            System.out.println("valid query passed as expected");
        }else {
            System.out.println("valid query failed unexpectedly, possible bug");
        }

    }

    // ----------------- Programming Based Testing -------------
    // Schema I am testing: scheme+authority+port+path+query
    // <scheme>://<authority><path>?<query>

    // Loop though different scheme and authorities
    public void testSchemeAndAuthority() {

        System.out.println("Running programming based testing for scheme+authority...");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        String url;
        Boolean urlValid;
        for (ResultPair i : testUrlScheme) {

            for (ResultPair j : testUrlAuthority) {
                url = i.item + j.item;
                urlValid = urlVal.isValid(url);
                if ((i.valid && j.valid && urlValid) || ((!i.valid || !j.valid) && !urlValid)) {
                    // Tests pass if both components are valid and the url is
                    // valid
                    // OR
                    // if either of the components are invalid and the url is
                    // invalid
                    System.out.println("Passed: URL -> <" + url + ">... Expected: " + (i.valid && j.valid)
                            + ". Actual: " + urlValid);
                } else {
                    System.out.println("Failed: URL -> <" + url + ">. Expected: " + (i.valid && j.valid) + ". Actual: "
                            + urlValid);
                }
            }
        }
    }

    // Loop though different different ports with the rest of the url being
    // valid
    public void testPort() {

        System.out.println("Running programming based testing for port...");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        String baseUrl = "http://www.google.com";
        String url;
        Boolean urlValid;

        for (ResultPair j : testUrlPort) {
            url = baseUrl + j.item;
            urlValid = urlVal.isValid(url);
            if ((j.valid && urlValid) || (!j.valid && !urlValid)) {
                // Tests pass if port is valid and the url is valid
                // OR
                // if port is invalid and the url is invalid
                System.out.println("Passed: URL -> <" + url + ">... Expected: " + j.valid + ". Actual: " + urlValid);
            } else {
                System.out.println("Failed: URL -> <" + url + ">... Expected: " + j.valid + ". Actual: " + urlValid);
            }
        }
    }

    // Loop though different paths with the rest of the url being valid
    public void testPath() {

        System.out.println("Running programming based testing for path...");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        String baseUrl = "http://www.google.com:80";
        String url;
        Boolean urlValid;

        for (ResultPair j : testUrlPath) {
            url = baseUrl + j.item;
            urlValid = urlVal.isValid(url);
            if ((j.valid && urlValid) || (!j.valid && !urlValid)) {
                // Tests pass if port is valid and the url is valid
                // OR
                // if port is invalid and the url is invalid
                System.out.println("Passed: URL -> <" + url + ">... Expected: " + j.valid + ". Actual: " + urlValid);
            } else {
                System.out.println("Failed: URL -> <" + url + ">... Expected: " + j.valid + ". Actual: " + urlValid);
            }
        }
    }

    // Loop though different queries with the rest of the url being valid
    public void testQuery() {

        System.out.println("Running programming based testing for query...");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        String baseUrl = "http://www.google.com:80/blah";
        String url;
        Boolean urlValid;

        for (ResultPair j : testUrlQuery) {
            url = baseUrl + j.item;
            urlValid = urlVal.isValid(url);
            if ((j.valid && urlValid) || (!j.valid && !urlValid)) {
                // Tests pass if port is valid and the url is valid
                // OR
                // if port is invalid and the url is invalid
                System.out.println("Passed: URL -> <" + url + ">... Expected: " + j.valid + ". Actual: " + urlValid);
            } else {
                System.out.println("Failed: URL -> <" + url + ">... Expected: " + j.valid + ". Actual: " + urlValid);
            }
        }
    }

    //These result pairs are used to test the different parts of a URL to check their validity. So each type of Result pair
    //is used in a different function to test that part of the URL eg testUrlPath result pair is used in testPath method.

    ResultPair[] testUrlScheme = { new ResultPair("http://", true), new ResultPair("https://", true),
            new ResultPair("ftp://", true), new ResultPair("blah://", true), new ResultPair("://", false),
            new ResultPair("/", false), new ResultPair(":", false), new ResultPair("123", false),
            new ResultPair("!!", false), new ResultPair("http:", false), };

    ResultPair[] testUrlAuthority = { new ResultPair("www.google.com", true), new ResultPair("google.com", true),
            new ResultPair("192.168.0.0", true), new ResultPair("1000.1000.1000.1000", false), new ResultPair("1.1.1.256", false),
            new ResultPair("1000.10.10.10", false), new ResultPair("....", false), new ResultPair("abc", false),
            new ResultPair("123", false), new ResultPair(".a.b.a.", false) };

    ResultPair[] testUrlPort = { new ResultPair("", true), new ResultPair(":80", true), new ResultPair(":8080", true),
            new ResultPair(":80808", true), new ResultPair(":808080", false), new ResultPair(":8a", false),
            new ResultPair(":8A", false), new ResultPair(":88A8", false), new ResultPair(":8AAAAA", false),
            new ResultPair(":!@#", false), new ResultPair(":-100", false) };

    ResultPair[] testUrlPath = { new ResultPair("", true), new ResultPair("/blah", true), new ResultPair("/.", true),
            new ResultPair("/..", false), new ResultPair("/...", false), new ResultPair("/?", true),
            new ResultPair("/??", true), new ResultPair("/blah/foo", true), new ResultPair("/blah/foo/bar", true) };

    ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
            new ResultPair("?action=edit&mode=up", true),
            new ResultPair("", true)
    };
}
