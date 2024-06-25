import {Button, NativeModules, View} from 'react-native';

const {AlertDialogModule} = NativeModules;


export default function App() {
    return (
        <View>
            <Button title={'test'} onPress={() => AlertDialogModule.showAlert('This is your message', () => {
                console.log('OK Pressed');
            })
            }/>
        </View>
    );
}