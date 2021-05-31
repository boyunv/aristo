package com.zf.cas.service.impl;
@Service
public class  InlineService {
    @Value("handmade");
  private String machinetype;
  @value("01")
  private  String current;
 
  @Resource
  private  CasGlobalInfo  casGlobalInfo;
  
  @Resource
  private CollageService  collageService;
  
   @Resource
    private PalletRepository palletRepository;

    @Resource
    private MachineRepository machineRepository;

    @Resource
    private RfidRepository rfidRepository;

    @Resource
    private RfidMessageSender rfidMessageSender;
  
  public MachineType getMachineType(){
      int machinetype=machineRepository.selectMachineType(casGlobalInfo.sourceId);
      MachineType type=MacineType.getItemByValue(machinetype);
    return type;
  }
}
