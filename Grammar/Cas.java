package com.sineva.cas;

import com.sineva.cas.common.plc.PlcGrpcRegister;
import com.sineva.cas.common.rfid.RfidGrpcRegister;
import com.sineva.cas.common.rfid.RfidMessageSender;
import com.sineva.cas.domain.define.MachineType;
import com.sineva.cas.domain.entity.RfidEntity;
import com.sineva.cas.service.api.CollageService;
import com.sineva.cas.service.api.InlineService;
import com.sineva.cas.service.api.PrepareDishService;
import com.sineva.cas.service.api.VestibuleService;
import com.sineva.cas.service.impl.QuartzService;
import com.sineva.cas.service.impl.RestTemplateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import java.util.List;

@SpringBootApplication
@IntegrationComponentScan
@EnableIntegration
//@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class CasApplication {
    private CollageService collageService;
    private PlcGrpcRegister plcGrpcRegister;
    private RfidGrpcRegister rfidGrpcRegister;
    private RfidMessageSender rfidMessageSender;
    private PrepareDishService prepareDishService;
    private QuartzService quartzService;
    private InlineService inlineService;
    private VestibuleService vestibuleService;


    public static void main(String[] args) {
        SpringApplication.run(CasApplication.class, args);
    }

    public CasApplication(RestTemplateService restTemplateService,
                          CollageService collageService,
                          PlcGrpcRegister grpcRegister,
                          RfidGrpcRegister rfidGrpcRegister,
                          RfidMessageSender rfidMessageSender,
                          PrepareDishService prepareDishService,
                          InlineService inlineService,
                          QuartzService quartzService,
                          VestibuleService vestibuleService)
    {
        this.collageService = collageService;
        this.plcGrpcRegister = grpcRegister;
        this.rfidGrpcRegister = rfidGrpcRegister;
        this.rfidMessageSender = rfidMessageSender;
        this.prepareDishService = prepareDishService;
        this.inlineService = inlineService;
        this.quartzService = quartzService;
        this.vestibuleService = vestibuleService;
        //restTemplateService.gettest();
        this.initial();
    }

    public void initial()
    {
        MachineType type = inlineService.getMachineType();
        List<RfidEntity> rfidEntities = inlineService.getOwnerRfid(type);
        switch (type){
            case DISH_LINE:
                /*plcGrpcRegister.start();
                rfidGrpcRegister.start();
                rfidMessageSender.initial(rfidEntities);*/
//               this.collageService.initCollageInfo();
                collageService.start();
                break;
            case POT_LINE:
                //plcGrpcRegister.start();
                break;
            case STOCK_LINE:
                rfidGrpcRegister.start();
                rfidMessageSender.initial(rfidEntities);
                prepareDishService.startScale();
                break;
            case ELEVATOR_LINE:
                //rfidGrpcRegister.start();
                //rfidMessageSender.initial(rfidEntities);
                quartzService.createHolidayJob();
                quartzService.createDishSummaryJob();
                vestibuleService.executeOrderTask();
                break;
        }
    }
}
