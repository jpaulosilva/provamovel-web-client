<?php 

$url = 'https://graph.facebook.com/me?access_token=CAAXeXFkyfSoBAAQmFGQZBsMIZBZBWZBAoBEMrqEgfz8dZAy4N58OCRfuSPj04aHrbGZBALHIlRXovFAuYYSESZAv7dxN5LUNtgPuZBhvrgBDPPNQZAMJADFkMhqBK2AP9vmbqqjbFbXbJ2ynqoiZBzE9LB4JlvKvRtLr2w0CaZCpR6Neg1bC0KFU2YWlEHkphDcJV7J4aZAZAC2ZAp5l9qFUu7IEHz';


$requests = file_get_contents($url);
echo($requests);

?>