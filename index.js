//FIXME сделать
import { NativeModules } from 'react-native';

export default const CallLog = {
    getList: (params, callback) => {
        //FIXME params
        return NativeModules.CallLog.getCallLog(callback);
    }
};
