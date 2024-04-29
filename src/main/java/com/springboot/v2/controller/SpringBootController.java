package com.springboot.v2.controller;

import com.springboot.v2.intercetors.TogglingFeaturesMbean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class SpringBootController {
    private final static Logger LOG = LoggerFactory.getLogger(SpringBootController.class);
    @Autowired
    Environment env;

    @Autowired
    private TogglingFeaturesMbean bean;



    @GetMapping(value = "/claim/{claimNo}")
    public ResponseEntity<String> getClaimRecord(@RequestParam Map<String, String> requestParams, @PathVariable(value = "claimNo") String claimNo, HttpServletRequest request, HttpServletResponse response, Authentication authenticationToken) throws Exception {
        if (bean.isGetClaimRecord()) {
            LOG.info("read claim by claim number feature is active");

            String result = "";

            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Read claim by claim number feature is not available", HttpStatus.OK);
        }
    }


    @PostMapping(value = "/claim")
    public ResponseEntity<String> postClaimRecord(@RequestParam Map<String, String> requestParams, final HttpServletRequest request, final HttpServletResponse response, Authentication authenticationToken) throws Exception {
        if (bean.isPostClaimRecord()) {
            LOG.info("add claim by claim number feature is active");

            String result = "";

            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("add claim by claim number feature is not available", HttpStatus.OK);
        }
    }


    @PutMapping(value = "/claim/{claimNumber}")

    public ResponseEntity<String> updateClaimRecord(@RequestParam Map<String, String> requestParams, @PathVariable(value = "claimNumber") String claimNumber, final HttpServletRequest request, final HttpServletResponse response, Authentication authenticationToken) throws Exception {
        if (bean.isUpdateClaimRecord()) {
            LOG.info("update claim feature is active");

            String result = "";

            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("update claim feature is not available", HttpStatus.OK);
        }
    }



    @DeleteMapping(value = "/claim/{claimNumber}")

    public ResponseEntity<String> deleteClaimRecord(@RequestParam Map<String, String> requestParams, @PathVariable(value = "claimNumber") String claimNumber, final HttpServletRequest request, final HttpServletResponse response, Authentication authenticationToken) throws Exception {
        if (bean.isDeleteClaimRecord()) {
            LOG.info("delete claim Record feature is active");
            String result = "";
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("delete claim feature is not available", HttpStatus.OK);
        }
    }

}
