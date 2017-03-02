import { NativeModules } from 'react-native';
export default CallLog = {
    getList: (params={}) => NativeModules.CallLog.getCallLog(params)
};
